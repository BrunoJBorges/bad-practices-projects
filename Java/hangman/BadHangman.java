package refatoracao;

import java.util.ArrayList;
import java.util.Scanner;

public class BadHangman {
    
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        BadHangman game = new BadHangman();
        ArrayList<String> words = new ArrayList<>();
        words.add("programming");
        words.add("java");
        words.add("legacy");
        words.add("refactor");
        words.add("hangman");
        
        boolean keepPlaying = true;
        
        while (keepPlaying) {
            String word = words.get((int) (Math.random() * words.size()));
            char[] guessedWord = new char[word.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '_';
            }
            
            ArrayList<Character> incorrectGuesses = new ArrayList<>();
            boolean wordGuessed = false;
            int attemptsLeft = 6;
            
            while (!wordGuessed && attemptsLeft > 0) {
                System.out.println("Word: " + String.valueOf(guessedWord));
                System.out.println("Incorrect guesses: " + incorrectGuesses);
                System.out.println("Attempts left: " + attemptsLeft);
                System.out.print("Guess a letter: ");
                char guess = scanner.next().charAt(0);
                
                if (word.indexOf(guess) >= 0) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            guessedWord[i] = guess;
                        }
                    }
                } else {
                    if (!incorrectGuesses.contains(guess)) {
                        incorrectGuesses.add(guess);
                        attemptsLeft--;
                    }
                }
                
                wordGuessed = true;
                for (char c : guessedWord) {
                    if (c == '_') {
                        wordGuessed = false;
                        break;
                    }
                }
            }
            
            if (wordGuessed) {
                System.out.println("Congratulations! You guessed the word: " + word);
            } else {
                System.out.println("You lost! The word was: " + word);
            }
            
            System.out.print("Play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                keepPlaying = false;
            }
        }
        
        scanner.close();
    }
}
