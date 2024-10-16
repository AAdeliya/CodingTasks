class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

class StudentScoreProcessor {

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\kalas\\Downloads\\students.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                String scoreStr = data[1];

                try {
                    int score = Integer.parseInt(scoreStr);

                    // Validate the score and throw custom exception if out of range
                    if (score < 0 || score > 100) {
                        throw new InvalidScoreException("Invalid score for " + name + ": " + score);
                    }

                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing score for " + name + ": " + scoreStr);
                } catch (InvalidScoreException e) {
                    System.err.println(e.getMessage());
                }
            }

            // Calculate average score
            if (!scores.isEmpty()) {
                double average = scores.stream().mapToInt(Integer::intValue).average().orElse(0);
                System.out.println("Average score: " + average);
            } else {
                System.out.println("No valid scores to calculate average.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            // Ensure resources are closed
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
        }
    }
}