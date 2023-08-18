import java.util.Scanner;
import com.bankutils.create.CreateUser;
import com.bankutils.create.Account.BankAccount;

public class App {
    private CreateUser user = new CreateUser();
    private BankAccount bankAccount = new BankAccount();

    public static void main(String[] args) throws Exception {
        App app = new App();
        Scanner data = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Escolha uma função");
            System.out.print("1. Criar conta \n2. Entrar na conta \n3. Sair\n");
            int option = data.nextInt();

            switch (option) {
                case 1:
                    app.sectionCreateUser();
                    break;
                case 2:
                    app.sectionLogin();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }

        data.close();
    }

    public void sectionCreateUser() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Vamos criar sua conta");
        Scanner data = new Scanner(System.in);
        System.out.print("Primeiro, insira seu nome");
        String name = data.nextLine();
        System.out.print("Agora, crie uma senha, de no minimo 8 digitos");
        String password = data.nextLine();
        if (password.length() < 8) {
            System.out.println("Sua senha deve ter no minimo 8 digitos");
        }
        System.out.print("Agora, insira seu CPF");
        String cpf = data.nextLine();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Confirme seus dados");
        System.out.println("Nome: " + name);
        System.out.println("Senha: " + password);
        System.out.println("CPF: " + cpf);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("1. Confirmar \n 2. Cancelar");
        int confirm = data.nextInt();
        if (confirm == 1) {
            user.registerUser(name, password, cpf);
            int nmAgencia = (int) (Math.random() * 10000);
            bankAccount.createBankAccount(0.0, name, nmAgencia);
        } else {
            System.out.println("Conta não foi criada");
        }
    }

    public void sectionLogin() {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Faça login");
            Scanner loginData = new Scanner(System.in);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Insira seu nome");
            String nameLogin = loginData.nextLine();
            System.out.println("Insira sua senha");
            String passwordLogin = loginData.nextLine();
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Confirme seus dados");
            System.out.println("Nome: " + user.getName());
            System.out.println("Senha: " + user.getPassword());
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            String originalUser = user.getName();
            String originalPassword = user.getPassword();

            if (nameLogin.equals(originalUser) && passwordLogin.equals(originalPassword)) {
                System.out.println("Logado com sucesso");
                bankAccount.getSaldo();
                bankAccount.getAgency();

                while (true) {
                    System.out.println("Escolha uma função");
                    System.out.println("1. Adicionar valor \n2. Sacar valor \n3. Sair");
                    int choose = loginData.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("Insira o valor que deseja depositar");
                            double valor = loginData.nextDouble();
                            bankAccount.adicionarSaldo(valor);
                            bankAccount.getSaldo();
                            break;
                        case 2:
                            System.out.println("Insira o valor que deseja sacar");
                            double valor2 = loginData.nextDouble();
                            bankAccount.removerSaldo(valor2);
                            bankAccount.getSaldo();
                            break;
                        case 3:
                            loggedIn = true;
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }
            } else {
                System.out.println("Usuário ou senha incorretos");
                loggedIn = true;
            }
        }
    }
}
