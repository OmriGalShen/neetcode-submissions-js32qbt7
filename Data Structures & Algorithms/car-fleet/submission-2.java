class Solution {
    record Car(int position, int speed) {
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        cars.sort(Comparator.comparingInt(Car::position));
        int res = 0;
        double latestTime = 0;

        for (int i = cars.size() - 1; i >= 0; i--) {
            Car car = cars.get(i);
            double time = (target - car.position) / (double) car.speed;
            if (time > latestTime) {
                res++;
                latestTime = time;
            }
        }
        return res;
    }
}