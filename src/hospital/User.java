package hospital;

import com.sun.istack.internal.NotNull;
import hospital.menu.*;

public class User extends SystemComponent {
    private static final Menu DEFAULT_USER_MENU =
            new Menu("main",
                    new Menu("settings",
                            new ChangePasswordMenu(),
                            new Menu("change email")
                    ),
                    new BookAppointmentMenu(),
                    new CheckAppointmentsMenu(),
                    new SetPersonalDataMenu()
            );

    private String login;
    private String password;
    private Menu menu;
    private Person personalData;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.menu = DEFAULT_USER_MENU;
        this.personalData = null;
    }

    public User(String login, String password, Menu menu) {
        this.login = login;
        this.password = password;
        this.menu = menu;
        this.personalData = null;
    }

    public void showInterface() {
        menu.run();
    }

    public String getLogin() {
        return login;
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword))
            password = newPassword;
    }

    @Override
    public void setSystem(HospitalSystem system) {
        this.system = system;
        menu.setSystem(system);//?
    }

    public Person getPersonalData() {
        return personalData;
    }

    public void setPersonalData(@NotNull Person personalData){
        this.personalData = personalData;
    }
}
//    Dodaj referencję na obiekt Person wewnątrz klasy User, która będzie inicjalizowana nowym obiektem (Person, Doctor albo Patient)
//    kiedy użytkownik pierwszy raz się loguje. Tzn przy logowaniu mamy sprawdzać czy ta referencja jest nullem,
//        a jeśli tak to odpalić interfejs pytający przynajmniej o dane osobowei typ konta i przypisać ją do
//            obiektu usera który właśnie się loguje. Referencja ta powinna zostać też wrzucona do
//                odpowiedniego kontenera w instancji klasy DataBase w systemie. Dzięki temu każdy użytkownik systemu ma
//        przyporządkowany rekord z danymi osobowymi w bazie danych, a jeśli jest lekarzem lub pacjentem,
//        to rekord ten jest po prostu instancją klasy pochodnej po Person (Patient albo Doctor).
//
