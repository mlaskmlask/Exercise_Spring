package root.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import root.database.IShopRepository;
import root.database.IUserRepository;
import root.model.Product;

import java.util.List;
import java.util.Scanner;

@Component
public class GUI {

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IShopRepository shopRepository;

    static Scanner scanner = new Scanner(System.in);

    public void showLoginMenu() {
        System.out.println("1. Zaloguj się.");
        System.out.println("2. Zarejestruj się.");
        switch (scanner.nextLine()) {
            case "1":
                showLoginScreen();
                break;
            case "2":
                showRegisterScreen();
                break;
            default:
                System.out.println("Błędne dane.");
                showLoginMenu();
        }
    }

    private void mainMenu() {
        System.out.println("1. Wyświetl wszystko.");
        System.out.println("2. Wyświetl sprzęt RTV.");
        System.out.println("3. Wyświetl sprzęt AGD.");
        System.out.println("4. Dokonaj zakupu.");
        System.out.println("5. Wyjdź.");

        switch (scanner.nextLine()) {
            case "1":
                showAllProducts();
                mainMenu();
                break;
            case "2":
                showRTV();
                mainMenu();
                break;
            case "3":
                showAGD();
                mainMenu();
                break;
            case "4":
                buyProduct();
                mainMenu();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Błędnie podana liczba.");
                mainMenu();
        }

    }

    private void showLoginScreen() {
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String pass = scanner.nextLine();
        boolean authenticationResult = userRepository.authenticate(login, pass);
        if (authenticationResult) {
            System.out.println("Zalogowano");
            mainMenu();
        } else {
            System.out.println("Niepoprawne dane");
            showLoginMenu();
        }
    }

    private void showRegisterScreen() {
        System.out.println("Podaj login");
        String login = scanner.nextLine();
        System.out.println("Podaj hasło");
        String pass = scanner.nextLine();
        boolean registerResult = userRepository.register(login, pass);
        if (registerResult) {
            System.out.println("Rejestracja udana");
            showLoginMenu();
        } else {
            System.out.println("Rejestracja nieudana");
        }
    }

    private void showAllProducts() {
        List<Product> productList = shopRepository.getProducts();
        for (Product currentProduct : productList) {
            System.out.println(currentProduct);
        }
    }

    private void showRTV() {
        List<Product> rtv = shopRepository.getRTV();
        for (Product currentProduct : rtv) {
            System.out.println(currentProduct);
        }
    }

    private void showAGD() {
        List<Product> agd = shopRepository.getAGD();
        for (Product currentProduct : agd) {
            System.out.println(currentProduct);
        }
    }

    private void buyProduct() {
        System.out.println("Podaj nazwę produktu: ");
        String nameBuy = scanner.nextLine();
        System.out.println("Podaj ilość");
        int piecesBuy = Integer.parseInt(scanner.nextLine());
        if (shopRepository.buyProd(nameBuy, piecesBuy)) {
            System.out.println("Zakupiono " + nameBuy + " w ilości " + piecesBuy + " sztuk.");
        } else {
            System.out.println("Zakup nieudany. Spróbuj jeszcze raz!");
        }
    }
}