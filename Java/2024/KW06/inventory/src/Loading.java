public class Loading {

    public static void loadingAnimationWithTimer(long durationMillis) {
        int numOfDots = 3;
        int delay = 500; // milliseconds
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < durationMillis) {
            // Print dots
            for (int i = 0; i < numOfDots; i++) {
                System.out.print(".");
                try {
                    Thread.sleep(delay); // Pause for a while
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Clear dots
            for (int i = 0; i < numOfDots; i++) {
                System.out.print("\b \b"); // Move cursor back and print space to clear dot
                try {
                    Thread.sleep(delay); // Pause for a while
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
