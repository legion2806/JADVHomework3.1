public class Main {

    public static void main(String[] args) {

        ToggleSwitch toggleswitch = new ToggleSwitch();

        Thread user = new Thread(null, toggleswitch::on, "Пользователь");
        Thread toy = new Thread(null, toggleswitch::off, "Игрушка");
        System.out.println("Начинаем игру!");

        try {
            user.start();
            toy.start();

            user.join();
            System.out.println("Игра закончена!");
            toy.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}