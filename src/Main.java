import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BDComida bdComida = new BDComida();
    //    static Comida cafe = new Cafe("1", 1, "1", 1);
    static BDMaterial bdMaterial = new BDMaterial();

    public static void main(String[] args) {
//        bdComida.create(cafe);
        menu();
    }

    private static void menu() {
        int opcao;
        do {
            System.out.println("""
                    BEM-VINDO!
                                    
                    Informe qual opção você deseja?
                                        
                    0- Sair    
                    1- Confeitaria (alimentos que são encontrados na padaria)
                    2- Materiais escolares
                    """);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuComida();
                    break;
                case 2:
                    menuMaterial();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }


    private static void menuComida() {
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
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    createComida();
                    break;
                case 2:
                    readOneComida();
                    break;
                case 3:
                    readAllComida();
                    break;
                case 4:
                    upDateComida();
                    break;
                case 5:
                    deleteComida();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void createComida() {
        int opcao;
        do {
            System.out.println("""
                    Informe a opção que você deseja criar:
                                    
                                    
                    0- Voltar para o menu principal                
                    1- Café
                    2- Pão
                    3- Torta
                    """);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criarCafe(false, 0);
                    break;
                case 2:
                    criarPao(false, 0);
                    break;
                case 3:
                    criarTorta(false, 0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
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
            cadastrarComida(verificarSeExisteComida(codigo), codigo, preco, tipo, acidez, 1);
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
            cadastrarComida(verificarSeExisteComida(codigo), codigo, preco, tipo, comprimento, 2);
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
            cadastrarComida(verificarSeExisteComida(codigo), codigo, preco, recheio, diametro, 3);
        } else {
            Comida tortaAdd = new Torta(codigo, preco, id, recheio, diametro);
            bdComida.upDate(id, tortaAdd);
        }
    }

    private static boolean verificarSeExisteComida(String codigo) {
        for (Comida comida : bdComida.readAll()) {
            if (comida.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static boolean verificarSeExisteComida() {
        if (bdComida.readAll().isEmpty()) {
            System.out.println("Ainda não há nenhum alimento cadastrado!");
            return true;
        }
        return false;
    }


    private static void cadastrarComida(boolean cadastrado, String codigo, double preco, String atributoString,
                                        double atributoDouble, int tipo) {
        if (cadastrado) {
            System.out.println("Já existe uma comida com este código!");
        } else {
            Comida comidaAdd = null;
            if (tipo == 1) {
                comidaAdd = new Cafe(codigo, preco, atributoString, atributoDouble);
            } else if (tipo == 2) {
                comidaAdd = new Pao(codigo, preco, atributoString, atributoDouble);
            } else if (tipo == 3) {
                comidaAdd = new Torta(codigo, preco, atributoString, atributoDouble);
            }
            bdComida.create(comidaAdd);
            System.out.println("Comida cadastrada com sucesso!");
        }
    }

    private static void readOneComida() {
        if (!verificarSeExisteComida()) {
            int cont = 0;
            for (Comida comidaFor : bdComida.readAll()) {
                cont++;
                System.out.println(cont + "- ");
                if (comidaFor instanceof Cafe) {
                    System.out.println(comidaFor.toStringNome() + "\n");
                } else if (comidaFor instanceof Pao) {
                    System.out.println(comidaFor.toStringNome() + "\n");
                } else if (comidaFor instanceof Torta) {
                    System.out.println(comidaFor.toStringNome() + "\n");
                }
            }
            System.out.println("Informe o ID da comida que deseja vizualizar:");
            int id = scanner.nextInt();
            System.out.println(bdComida.readOne(id).toString());
        }
    }

    private static void readAllComida() {
        if (!verificarSeExisteComida()) {
            int cont = 0;
            for (Comida comida : bdComida.readAll()) {
                cont++;
                System.out.println(cont + "- " + comida.toString() + "\n");
            }
        }
    }

    private static void upDateComida() {
        if (!verificarSeExisteComida()) {
            int id = mostrarComidas();
            for (Comida comida : bdComida.readAll()) {
                if (id == comida.getId() && comida instanceof Cafe) {
                    criarCafe(true, comida.getId());
                    break;
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

    private static void deleteComida() {
        if (!verificarSeExisteComida()) {
            int id = mostrarComidas();
            bdComida.delete(id);
        }
    }

    private static void menuMaterial() {
    }
}
