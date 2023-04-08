import java.util.Random;
/**
 * @author Pamanin
 * @version 1.0
 * Многопоточная программа
 * Бег с препятствиями.
 * Создается условная карта трассы в виде матрицы,
 * ширина которой соответствует количеству бегунов,
 * а высота – фиксирована, содержащей произвольное количество единиц (препятствий)
 * в произвольных ячейках. Стартующие бегуны (процессы, потоки)
 * перемещаются по трассе и при встрече с препятствием задерживаются на фиксированное время.
 * По достижении финиша бегуны сообщают свой номер.
 */
class ObstacleRace implements Runnable {

    // длина трассы
    private static final int RACE_LENGTH = 10;
    // вероятность появления препятствия, в процентах
    private static final int OBSTACLE_PROBABILITY = 20;
    // время задержки при столкновении с препятствием, в миллисекундах
    private static final int DELAY_TIME = 1000;

    // флаг завершения гонки
    private static boolean FINISHED = false;
    // номер победителя гонки
    private static int WINNER = -1;

    // номер бегуна
    private int runnerNumber;
    // текущая позиция бегуна на трассе
    private int currentPosition = 0;
    // генератор случайных чисел
    private Random rand = new Random();

    /**
     * Конструктор класса ObstacleRace.
     * @param runnerNumber - порядковый номер бегуна.
     */
    public ObstacleRace(int runnerNumber) {
        this.runnerNumber = runnerNumber;
    }

    /**
     * Метод run() потока-бегуна.
     */
    @Override
    public void run() {
        while (!FINISHED) {
            // генерация случайного числа от 0 до 99
            int obstacle = rand.nextInt(100);
            if (obstacle < OBSTACLE_PROBABILITY) {
                // при столкновении с препятствием
                System.out.println("Бегун № " + runnerNumber + " столкнулся с препятствием в позиции " + currentPosition);
                try {
                    // ожидание
                    Thread.sleep(DELAY_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // если нет препятсвий
                currentPosition++;
                if (currentPosition >= RACE_LENGTH) {
                    // если бегун достиг конца трассы
                    FINISHED = true;
                    WINNER = runnerNumber;
                    System.out.println("Бегун № " + runnerNumber + " финишировал первым");
                }
            }
        }
    }

    /**
     * Главный метод программы.
     * @param args - параметры командной строки.
     */
    public static void main(String[] args) {
        // создание массива потоков-бегунов
        Thread[] runners = new Thread[RACE_LENGTH];
        for (int i = 0; i < RACE_LENGTH; i++) {
            // создание объекта-бегуна с порядковым номером i+1
            ObstacleRace runner = new ObstacleRace(i + 1);
            // создание потока для бегуна и добавление его в массив потоков
            runners[i] = new Thread(runner);
            // запуск потока бегунов
            runners[i].start();
        }
        // создание потока вывода результатов
        Thread results = new Thread(() -> {
            // ожидание завершения гонки
            while (!FINISHED) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // вывод номера победителя
            System.out.println("Победил бегун №" + WINNER);
        });
        // запуск потока вывода
        results.start();
    }
}