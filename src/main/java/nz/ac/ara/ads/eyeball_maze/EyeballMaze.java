package nz.ac.ara.ads.eyeball_maze;

public class EyeballMaze {
    public int tryCount = 0;
    protected int correctNumber;
    protected int guessNum;
    protected boolean finished = false;

    public EyeballMaze(int numberInput) {
        this.correctNumber = numberInput;
    }
    public EyeballMaze() {
        this.correctNumber = this.generateRandomSecretNum();
    }
    public int generateRandomSecretNum() {
        return (int)(Math.random()*100);
    }
/*
    public void takeGuess() {
        Scanner scanner = new Scanner(System.in);
        while (!finished) {
            System.out.println("Enter a number: ");
            int inputNum = Integer.parseInt(scanner.nextLine());;
            this.makeGuess(inputNum);
        }
    }
*/

    public String makeGuess(int inputNum) {
        this.tryCount += 1;

        String result = "";

        if (inputNum > this.correctNumber) {
            result = "Try lower";
        }
        else if (inputNum == this.correctNumber) {
            result = "You got it in " + this.tryCount + " trials!";
            this.finished = true;
            this.tryCount = 0;
        }
        else {
            result = "Try higher";
        }
        System.out.println(result);
        return result;
    }

}