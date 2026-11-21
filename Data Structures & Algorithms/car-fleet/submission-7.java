class Solution {
    private record Car(int pos, int speed) {}

    // time: O(N*Log(N))
    // space: O(N)
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) {
            return 0;
        }
        List<Car> cars = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars, (a, b) -> Integer.compare(b.pos(), a.pos()));
        int fleets = 1;
        Car lastCar = cars.get(0);
        for (int i = 1; i < cars.size(); i++) {
            Car c = cars.get(i);
            double timeLastCar = (target - lastCar.pos()) / (double) lastCar.speed();
            double timeCurrCar = (target - c.pos()) / (double) c.speed();
            if (timeCurrCar > timeLastCar) {
                fleets++;
                lastCar = c;
            }
        }
        return fleets;
    }
}
