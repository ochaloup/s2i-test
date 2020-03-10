package cz.chalda.s2i;

/**
 * Hello world almost infinite!
 */
public final class HelloS2IInfinite {
    public static void main(String[] args) {
        int counter = getInitCounter();
        while(counter <= Integer.MAX_VALUE) {
            System.out.printf("Hello S2I! [#%d]%n", counter++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Processing interrupted", ie);
            }
        }
    }

    private static int getInitCounter() {
        int initCounter = 1;
        String initCounterString = System.getenv("INIT_COUNTER");
        if(initCounterString == null || initCounterString.isEmpty()) {
            System.out.println("Environmental variable 'INIT_COUNTER' was not specified. Starting with value 1.");
            return 1;
        }

        try {
            initCounter = Integer.valueOf(initCounterString);
        } catch (NumberFormatException nfe) {
            System.err.printf("Environmental variable 'INIT_COUNTER' is %s which can't be converted to integer. Starting with value 1.%n", initCounterString);
            return 1;
        }

        if (initCounter < 0) {
            System.err.printf("Environmental variable 'INIT_COUNTER' %d is number lower than 0. Starting with value 1.%n", initCounterString);
            return 1;
        }

        return initCounter;
    }
}
