class Solution {
    private record Car(int pos, int speed) {}

    // time: O(N*Log(N))
    // space: O(N)
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> cars = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            cars.add(new Car(position[i], speed[i]));
        }
        Collections.sort(cars, (a, b) -> Integer.compare(b.pos(), a.pos()));
        int fleets = 0;
        Car lastCar = null;
        for (Car c : cars) {
            if (lastCar == null) {
                lastCar = c;
                fleets = 1;
                continue;
            }
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
