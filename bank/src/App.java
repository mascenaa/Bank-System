import java.util.Scanner;
import com.bankutils.create.CreateUser;
import com.bankutils.create.Account.BankAccount;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner data = new Scanner(System.in);
        System.out.println("Escolha uma função");
        System.out.print("1. Criar conta \n 2. Entrar na conta \n");
        int option = data.nextInt();
        switch (option) {
            case 1:
                App app = new App();
                app.sectionCreateUser();
                return;
            case 2:
                App app2 = new App();
                app2.sectionLogin();
                return;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public void sectionCreateUser() {
        CreateUser createUser = new CreateUser();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Vamos criar sua conta");
        Scanner data = new Scanner(System.in);
        System.out.print("Primeiro, insira seu nome");
        String name = data.nextLine();
        System.out.print("Agora, crie uma senha, de no minimo 8 digitos");
        String password = data.nextLine();
        if (password.length() < 8) {
            System.out.println("Sua senha deve ter no minimo 8 digitos");
            return;
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
            createUser.registerUser(name, password, cpf, 0, 0001);
        } else {
            System.out.println("Conta não foi criada");
        }
        return;
    }

    public void sectionLogin() {
        System.out.println("Faça login");
        Scanner loginData = new Scanner(System.in);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Insira seu nome");
        String nameLogin = loginData.nextLine();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Insira sua senha");
        String passwordLogin = loginData.nextLine();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        // verify password and user with CreateUser user = new CreateUser();
        if (nameLogin.length() > 0 && passwordLogin.length() > 0) {
            System.out.println("Logado com sucesso");
            BankAccount bankAccount = new BankAccount();
            bankAccount.getSaldo();
            bankAccount.getAgency();

            System.out.println("Escolha uma função");
            System.out.println("1. Adicionar valor \n 2. Sacar valor \n 3. Sair");
            int choose = loginData.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Insira o valor que deseja depositar");
                    double valor = loginData.nextDouble();
                    bankAccount.adicionarSaldo(valor);

                    bankAccount.getSaldo();
                    return;
                case 2:
                    System.out.println("Insira o valor que deseja sacar");
                    double valor2 = loginData.nextDouble();
                    bankAccount.removerSaldo(valor2);

                    bankAccount.getSaldo();
                    return;
                case 3:
                    break;
                default:
                    System.out.println("???");
                    break;
            }
        } else {
            System.out.println("Usuário ou senha incorretos");
        }
    }
}
