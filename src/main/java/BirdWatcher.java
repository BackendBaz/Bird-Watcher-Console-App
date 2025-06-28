import java.util.Arrays;

class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay).anyMatch(day -> day == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int result = 0;
        if (numberOfDays < birdsPerDay.length) {
            for (int i = 0; i < numberOfDays; i++) result += birdsPerDay[i];
            return result;
        }
        return Arrays.stream(birdsPerDay).sum();
    }

    public int getBusyDays() {
        return Arrays.stream(birdsPerDay)
                .filter(day -> day >= 5)
                .toArray()
                .length;
    }

}
