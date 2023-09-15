import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static BDComida bdComida = new BDComida();
    static Comida cafe = new Cafe("1", 1, "1", 1);

    public static void main(String[] args) {
        bdComida.create(cafe);
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
//                    menuMaterial();
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
                    4- Fazer uma alteração 
                    5- Remover
                    0- Sair
                    """);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criarComida();
                    break;
                case 2:
                    listarApenasUm();
                    break;
            }
        } while (opcao != 0);
    }


    private static void criarComida() {
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
                    criarCafe();
                    break;
                case 2:
                    criarPao();
                    break;
                case 3:
                    criarTorta();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void criarCafe() {
        System.out.println("Informe o preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo de café (ex: Expresso):");
        String tipo = scanner.next();
        System.out.println("Informe a porcentagem de ácidez:");
        double acidez = scanner.nextDouble();

        boolean cafeCadastrado = verificarSeExiste(codigo);

        cadastrar(cafeCadastrado, codigo, preco, tipo, acidez);
    }


    private static void criarPao() {
        System.out.println("Informe o preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo de pão:");
        String tipo = scanner.next();
        System.out.println("Informe o comprimento do pão:");
        double comprimento = scanner.nextDouble();

        boolean paoCadastrado = verificarSeExiste(codigo);

        cadastrar(paoCadastrado, codigo, preco, tipo, comprimento);
    }

    private static void criarTorta() {
        System.out.println("Informeo preço:");
        double preco = scanner.nextDouble();
        System.out.println("Informe o código:");
        String codigo = scanner.next();
        System.out.println("Informe o tipo do recheio:");
        String recheio = scanner.next();
        System.out.println("Informe o diâmetro da torta:");
        double diametro = scanner.nextDouble();

        boolean tortaCadastrada = verificarSeExiste(codigo);

        cadastrar(tortaCadastrada, codigo, preco, recheio, diametro);
    }

    private static boolean verificarSeExiste(String codigo) {
        for (Comida comida : bdComida.readAll()) {
            if (comida.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    private static void cadastrar(boolean cadastrado, String codigo, double preco, String atributoString, double atributoDouble) {
        if (cadastrado) {
            System.out.println("Esta comida já está cadastrada!");
        } else {
            Comida cafeAdd = new Cafe(codigo, preco, atributoString, atributoDouble);
            bdComida.create(cafeAdd);
            System.out.println("Comida cadastrada com sucesso!");
        }
    }

    private static void listarApenasUm() {
        int opcao;
        do {
            System.out.println("""
                    Informe o produto que você deseja listar:
                                    
                                    
                    0- Voltar para o menu                
                    1- Café
                    2- Pão
                    3- Torta
                    """);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    mostrarCafe();
                    break;
                case 2:
//                   mostrarPao();
                    break;
                case 3:
//                   mostrarTorta();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

    }

    private static void mostrarCafe() {
        for (Comida comida : bdComida.readAll()) {
            if (comida instanceof Cafe) {
                System.out.println(comida.toStringNome() + "\n");
            } else if (comida instanceof Pao) {
                System.out.println(comida.toStringNome() + "\n");
            } else if (comida instanceof Torta) {
                System.out.println(comida.toStringNome() + "\n");
            }
        }
        System.out.println("Informe o ID da comida que deseja vizualizar:");
        int id = scanner.nextInt();
        System.out.println(bdComida.readOne(id).toString());
    }

}
