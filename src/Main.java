import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BDComida bdComida = new BDComida();
    static BDMaterial bdMaterial = new BDMaterial();


    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcao;
        do {
            System.out.println("""
                    Informe a opção que você deseja:
                                    
                    1- Criar 
                    2- Listar apenas 1
                    3- Listar todos
                    4- Fazer alteração 
                    5- Remover
                    0- Sair
                    """);
            opcao = scanner.nextInt();
            int tipoObjeto = escolherObjeto();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    create(tipoObjeto);
                    break;
                case 2:
                    readOne(tipoObjeto);
                    break;
                case 3:
                    readAll(tipoObjeto);
                    break;
                case 4:
                    upDate(tipoObjeto);
                    break;
                case 5:
                    delete(tipoObjeto);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static int escolherObjeto() {
        int opcao;
        do {
            System.out.println("""
                    Informe qual opção você deseja?
                                        
                    0- Sair    
                    1- Confeitaria (alimentos que são encontrados na padaria)
                    2- Materiais escolares
                    """);
            opcao = scanner.nextInt();

            if (opcao != 1 && opcao != 2 && opcao != 0) {
                System.out.println("Opção inválida!");
            }
        } while (!(opcao == 1 || opcao == 2 || opcao == 0));
        return opcao;
    }

    private static void create(int tipoObjeto) {
        int opcao;
        if (tipoObjeto == 1) {
            do {
                System.out.println(bdComida.menuCriar());
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        criarCafe(false, 0);
                        break;
                    case 2:
                        criarPao(false, 0);
                        break;
                    case 3:
                        criarTorta(false, 0);
                        break;
                    case 0: // Adicione esta opção para sair do loop
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        } else if (tipoObjeto == 2) {
            System.out.println(bdMaterial.menuCriar());
            opcao = scanner.nextInt();
            while (opcao != 0) {
                switch (opcao) {
                    case 0:
                        break;
                    case 1:
                        criarLivro(false, 0);
                        break;
                    case 2:
                        criarMarcaTexto(false, 0);
                        break;
                    case 3:
                        criarPapel(false, 0);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
                if (opcao != 0) {
                    break;
                }
            }
        }
    }

    private static void criarLivro(boolean upDate, int id) {
        System.out.println("Informe o preço: ");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código: ");
        String codigo = scanner.next();
        System.out.println("Informe o título do livro: ");
        String titulo = scanner.next();
        System.out.println("Informe a quantidade de páginas: ");
        double qtdePaginas = scanner.nextDouble();

        if (!upDate) {
            cadastrarMaterial(bdMaterial.verificarSeExisteObjeto(codigo), codigo, preco, titulo, qtdePaginas, 1);
        } else {
            Material livroAdd = new Livro(codigo, preco, id, titulo, qtdePaginas);
            bdMaterial.upDate(id, livroAdd);
        }
    }

    private static void criarMarcaTexto(boolean upDate, int id) {
        System.out.println("Informe o preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo de ponta:");
        String tipoPonta = scanner.next();
        System.out.println("Informe a quantidade de tinta:");
        double qtdeTinta = scanner.nextDouble();

        if (!upDate) {
            cadastrarMaterial(bdMaterial.verificarSeExisteObjeto(codigo), codigo, preco, tipoPonta, qtdeTinta, 2);
        } else {
            Material marcaTextoAdd = new MarcaTexto(codigo, preco, tipoPonta, qtdeTinta);
            bdMaterial.upDate(id, marcaTextoAdd);
        }
    }

    private static void criarPapel(boolean upDate, int id) {
        System.out.println("Informe o preço: ");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código: ");
        String codigo = scanner.next();
        System.out.println("Informe o tipo: ");
        String tipo = scanner.next();
        System.out.println("Informe o tamanho(cm): ");
        double tamanho = scanner.nextDouble();

        if (!upDate) {
            cadastrarMaterial(bdMaterial.verificarSeExisteObjeto(codigo), codigo, preco, tipo, tamanho, 3);
        } else {
            Material papelAdd = new Papel(codigo, preco, id, tipo, tamanho);
            bdMaterial.upDate(id, papelAdd);
        }
    }

    private static void criarCafe(boolean upDate, int id) {
        System.out.println("Informe o preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo de café (ex: Expresso):");
        String tipo = scanner.next();
        System.out.println("Informe a porcentagem de ácidez:");
        double acidez = scanner.nextDouble();

        if (!upDate) {
            cadastrarComida(bdComida.verificarSeExisteObjeto(codigo), codigo, preco, tipo, acidez, 1);
        } else {
            Comida cafeAdd = new Cafe(codigo, preco, id, tipo, acidez);
            bdComida.upDate(id, cafeAdd);
        }
    }

    private static void criarPao(boolean upDate, int id) {
        System.out.println("Informe o preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo de pão:");
        String tipo = scanner.next();
        System.out.println("Informe o comprimento do pão:");
        double comprimento = scanner.nextDouble();

        if (!upDate) {
            cadastrarComida(bdComida.verificarSeExisteObjeto(codigo), codigo, preco, tipo, comprimento, 2);
        } else {
            Comida paoAdd = new Pao(codigo, preco, id, tipo, comprimento);
            bdComida.upDate(id, paoAdd);
        }
    }

    private static void criarTorta(boolean upDate, int id) {
        System.out.println("Informeo preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo do recheio:");
        String recheio = scanner.next();
        System.out.println("Informe o diâmetro da torta:");
        double diametro = scanner.nextDouble();

        if (!upDate) {
            cadastrarComida(bdComida.verificarSeExisteObjeto(codigo), codigo, preco, recheio, diametro, 3);
        } else {
            Comida tortaAdd = new Torta(codigo, preco, id, recheio, diametro);
            bdComida.upDate(id, tortaAdd);
        }
    }

    private static boolean verificarSeExisteComida() {
        if (bdComida.readAll().isEmpty()) {
            System.out.println("Ainda não há nenhum alimento cadastrado!");
            return true;
        }
        return false;
    }

    private static boolean verificarSeExisteMaterial() {
        if (bdMaterial.readAll().isEmpty()) {
            System.out.println("Ainda não há nenhum material cadastrado!");
            return true;
        }
        return false;
    }

    private static void cadastrarComida(boolean cadastrado, String codigo, double preco, String atributoString,
                                        double atributoDouble, int tipo) {
        if (cadastrado) {
            System.out.println("Já existe uma comida com este código!");
        } else {
            Comida comidaAdd = bdComida.preCadastro(codigo, preco, atributoString, atributoDouble, tipo);
            bdComida.create(comidaAdd);
            System.out.println("Comida cadastrada com sucesso!");
        }
    }

    private static void cadastrarMaterial(boolean cadastrado, String codigo, double preco, String atributoString, double atributoDouble, int tipo) {
        if (cadastrado) {
            System.out.println("Já existe um material com este código!");
        } else {
            Material materialAdd = bdMaterial.preCadastro(codigo, preco, atributoString, atributoDouble, tipo);
            bdMaterial.create(materialAdd);
            System.out.println("Material cadastrado com sucesso!");
        }
    }

    private static void readOne(int tipoObjeto) {
        if (tipoObjeto == 1) {
            if (!verificarSeExisteComida()) {
                for (Comida comida : bdComida.readAll()) {
                    System.out.println(comida.toStringNome() + "\n");
                }
                System.out.println("Informe o ID da comida que deseja vizualizar:");
                int id = scanner.nextInt();
                System.out.println(bdComida.readOne(id).toString());
            }
        } else if (tipoObjeto == 2) {
            if (!verificarSeExisteMaterial()) {
                for (Material material : bdMaterial.readAll()) {
                    System.out.println(material.toStringNome() + "\n");
                }
            }
            System.out.println("Informe o ID do material que deseja vizualizar:");
            int id = scanner.nextInt();
            System.out.println(bdMaterial.readOne(id).toString());
        }
    }

    private static void readAll(int tipoObjeto) {
        if (tipoObjeto == 1) {
            if (!verificarSeExisteComida()) {
                for (Comida comida : bdComida.readAll()) {
                    System.out.println(comida.toString() + "\n");
                }
            }
        } else if (tipoObjeto == 2) {
            if (!verificarSeExisteMaterial()) {
                for (Material material : bdMaterial.readAll()) {
                    System.out.println(material.toString());
                }
            }
        }
    }

    private static void upDate(int tipoObjeto) {
        if (tipoObjeto == 1) {
            if (!verificarSeExisteComida()) {
                int id = mostrarComidas();
                for (Comida comida : bdComida.readAll()) {
                    if (id == comida.getId() && comida instanceof Cafe) {
                        criarCafe(true, comida.getId());
                        break;
                    } else if (id == comida.getId() && comida instanceof Pao) {
                        criarPao(true, comida.getId());
                        break;
                    } else if (id == comida.getId() && comida instanceof Torta) {
                        criarTorta(true, id);
                        break;
                    }
                }
            }
        } else if (tipoObjeto == 2) {
            if (!verificarSeExisteMaterial()) {
                int id = mostrarMaterias();
                for (Material material : bdMaterial.readAll()) {
                    if (id == material.getId() && material instanceof Livro) {
                        criarLivro(true, material.getId());
                        break;
                    } else if (id == material.getId() && material instanceof MarcaTexto) {
                        criarLivro(true, material.getId());
                        break;
                    } else if (id == material.getId() && material instanceof Papel) {
                        criarPapel(true, material.getId());
                        break;
                    }
                }
            }
        }
    }

    private static int mostrarComidas() {
        int cont = 0;
        for (Comida comida : bdComida.readAll()) {
            cont++;
            System.out.println(cont + "- " + comida.toStringNome());
        }
        System.out.println("Informe o ID do alimento que deseja selecionar: ");
        return scanner.nextInt();
    }

    private static int mostrarMaterias() {
        for (Material material : bdMaterial.readAll()) {
            System.out.println(material.toStringNome() + "\n");
        }
        System.out.println("Informe o ID do material que deseja vizualizar:");
        return scanner.nextInt();
    }


    private static void delete(int tipoObjeto) {
        if (tipoObjeto == 1) {
            if (!verificarSeExisteComida()) {
                int id = mostrarComidas();
                bdComida.delete(id);
            }
        } else if (tipoObjeto == 2) {
            if (!verificarSeExisteMaterial()) {
                int id = mostrarMaterias();
                bdMaterial.delete(id);
            }
        }
    }

}
