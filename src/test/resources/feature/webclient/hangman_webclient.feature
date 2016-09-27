Feature: Match input
    As a user I want to be able to input a letter and know what I previously input.

    Scenario: Input a letter
        Given: I am in the hangman page
        When I enter "c" 
        Then I see 'c' in old guesses
