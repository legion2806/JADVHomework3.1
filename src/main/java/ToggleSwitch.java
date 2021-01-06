public class ToggleSwitch {

    int count = 3;

    volatile boolean toggleSwitch = false;

    public void on() {
        while (count != 0){
            try {
                if (!toggleSwitch) {
                    toggleSwitch = true;
                    System.out.printf("%s: Включаю тумблер\n", Thread.currentThread().getName());
                    count--;
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void off() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
                if (toggleSwitch) {
                    toggleSwitch = false;
                    System.out.printf("%s: Выключаю тумблер\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}