package hospital.menu;

import hospital.HospitalSystem;

import java.util.function.Consumer;


public class CustomMenu extends Menu {
    private Consumer<HospitalSystem> function;

    public CustomMenu(String name, Consumer<HospitalSystem> function){
        super(name);
        this.function = function;
    }
    //idusera
    //idch0 idch1 idch2 ...

    @Override
    public Menu process() {
        function.accept(system);
        return parent;
    }
}
