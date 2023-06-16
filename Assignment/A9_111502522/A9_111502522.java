/*
Assignment 9
Name: 劉俊吾
Student Number: 111502522
Course 2023-CE1002-A
*/
package A9_111502522;

import java.util.Scanner;
import java.util.ArrayList;

public class A9_111502522 {
    public static void main(String[] args) {
        ArrayList<String> input_list = new ArrayList<String>();
        ArrayList<Token> Token_list = new ArrayList<Token>();
        Scanner input = new Scanner(System.in);
        String input_line;
        String command;
        int Identifier_count = 0, Number_count = 0, Special_Symbol_count = 0;
        int start_index, end_index;
        boolean recording_token, is_second_symbol;
        String current_token_type;
        // 這是應對++ -- += <= >= == != && || 的特殊情況設置的陣列
        char second_symbol_list[] = { '+', '-', '=', '&', '|' };

        while (true) {
            input_line = input.nextLine();
            if (input_line.equals("END_OF_FILE")) {
                break;
            }
            input_list.add(input_line);
        }
        for (int i = 0; i < input_list.size(); i++) {
            start_index = 0;
            end_index = 0;
            recording_token = false;
            current_token_type = "None";
            while (true) {
                if (Tools.identify_type(input_list.get(i).charAt(end_index)).equals("white")) {
                    if (recording_token == false && start_index == end_index) {
                        start_index++;
                        end_index++;
                    } else {
                        Token new_token = new Token();
                        new_token.get_token(input_list.get(i).substring(start_index, end_index));
                        Token_list.add(new_token);
                        if (current_token_type.equals("Identifier")) {
                            Identifier_count++;
                        } else if (current_token_type.equals("Number")) {
                            Number_count++;
                        } else {
                            Special_Symbol_count++;
                        }

                        start_index = end_index;
                        recording_token = false;
                        current_token_type = "None";
                    }
                } else if (Tools.identify_type(input_list.get(i).charAt(end_index)).equals("symbol")) {
                    if (recording_token == false && start_index == end_index) {
                        current_token_type = "Special_Symbol";
                        recording_token = true;
                        end_index++;
                    } else {
                        if (current_token_type.equals("Identifier") || current_token_type.equals("Number")) {
                            Token new_token = new Token();
                            new_token.get_token(input_list.get(i).substring(start_index, end_index));
                            if (current_token_type.equals("Identifier")) {
                                Identifier_count++;
                            } else {
                                Number_count++;
                            }
                            Token_list.add(new_token);

                            start_index = end_index;
                            recording_token = false;
                            current_token_type = "None";
                        } else if (current_token_type.equals("Special_Symbol")) {
                            is_second_symbol = false;
                            for (int j = 0; j < 5; j++) {
                                if (input_list.get(i).charAt(end_index) == second_symbol_list[j]) {
                                    Token new_token = new Token();
                                    new_token.get_token(input_list.get(i).substring(start_index, end_index + 1));
                                    Special_Symbol_count++;
                                    Token_list.add(new_token);

                                    end_index++;
                                    start_index = end_index;
                                    recording_token = false;
                                    current_token_type = "None";
                                    is_second_symbol = true;
                                    break;
                                }
                            }
                            if (is_second_symbol == false) {
                                Token new_token = new Token();
                                new_token.get_token(input_list.get(i).substring(start_index, end_index));
                                Special_Symbol_count++;
                                Token_list.add(new_token);

                                start_index = end_index;
                                recording_token = false;
                                current_token_type = "None";
                            }
                        }
                    }
                } else if (Tools.identify_type(input_list.get(i).charAt(end_index)).equals("number")) {
                    if (recording_token == false && start_index == end_index) {
                        current_token_type = "Number";
                        recording_token = true;
                        end_index++;
                    } else {
                        if (current_token_type.equals("Identifier")) {
                            end_index++;
                        } else if (current_token_type.equals("Number")) {
                            end_index++;
                        } else if (current_token_type.equals("Special_Symbol")) {
                            Token new_token = new Token();
                            new_token.get_token(input_list.get(i).substring(start_index, end_index));
                            Special_Symbol_count++;
                            Token_list.add(new_token);

                            start_index = end_index;
                            recording_token = false;
                            current_token_type = "None";
                        }
                    }
                } else if (Tools.identify_type(input_list.get(i).charAt(end_index)).equals("letter")) {
                    if (recording_token == false && start_index == end_index) {
                        current_token_type = "Identifier";
                        recording_token = true;
                        end_index++;
                    } else {
                        if (current_token_type.equals("Identifier")) {
                            end_index++;
                        } else if (current_token_type.equals("Number") || current_token_type.equals("Special_Symbol")) {
                            Token new_token = new Token();
                            new_token.get_token(input_list.get(i).substring(start_index, end_index));
                            if (current_token_type.equals("Number")) {
                                Number_count++;
                            } else {
                                Special_Symbol_count++;
                            }
                            Token_list.add(new_token);

                            start_index = end_index;
                            recording_token = false;
                            current_token_type = "None";
                        }
                    }
                } else if (Tools.identify_type(input_list.get(i).charAt(end_index)).equals("unknown")) {
                    if (recording_token == false && start_index == end_index) {
                        Token new_token = new Token();
                        new_token.get_token(input_list.get(i).substring(start_index, end_index + 1));
                        Token_list.add(new_token);

                        start_index++;
                        end_index++;
                    } else {
                        Token new_token = new Token();
                        new_token.get_token(input_list.get(i).substring(start_index, end_index));
                        Token_list.add(new_token);
                        if (current_token_type.equals("Identifier")) {
                            Identifier_count++;
                        } else if (current_token_type.equals("Number")) {
                            Number_count++;
                        } else {
                            Special_Symbol_count++;
                        }

                        start_index = end_index;
                        recording_token = false;
                        current_token_type = "None";
                    }

                }
                if (start_index == input_list.get(i).length() || end_index == input_list.get(i).length()) {
                    if (recording_token == true) {
                        Token new_token = new Token();
                        new_token.get_token(input_list.get(i).substring(start_index, end_index));
                        Token_list.add(new_token);
                        if (current_token_type.equals("Identifier")) {
                            Identifier_count++;
                        } else if (current_token_type.equals("Number")) {
                            Number_count++;
                        } else {
                            Special_Symbol_count++;
                        }
                    }
                    break;
                }
            }
        }
        while (true) {
            command = input.next();
            switch (command) {
                case "0":
                    input.close();
                    return;
                case "1":
                    System.out.println("Total number of tokens: " + Token_list.size());
                    break;
                case "2":
                    for (int i = 0; i < Token_list.size(); i++) {
                        System.out.println("[" + Token_list.get(i).return_token() + "]");
                    }
                    break;
                case "3":
                    System.out.println("dentifier: " + Identifier_count + ", Number: " + Number_count
                            + ", Special Symbol: " + Special_Symbol_count);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}

@SuppressWarnings("unused")
class Token {
    private String token;
    private String type;

    public void get_token(String token) {
        this.token = token;
    }

    public void get_token_type() {
        if (Tools.identify_type(token.charAt(0)) == "number") {
            this.type = "Number";
        } else if (Tools.identify_type(token.charAt(0)) == "letter") {
            this.type = "Identifier";
        } else if (Tools.identify_type(token.charAt(0)) == "symbol") {
            this.type = "Special_Symbol";
        } else {
            this.type = "unknown";
        }
    }

    public String return_token() {
        return token;
    }
}

class Tools {
    private static char[] symbol_list = { '+', '-', '*', '/', '>', '<', '=', '%', '&', '|', '^', '\'', '\"', '.', ',',
            '(', ')', '[', ']', '{', '}', '!', ':', ';' };

    public static String identify_type(char unidentified_input) {
        if (unidentified_input == ' ') {
            return "white";
        } else if (unidentified_input >= '0' && unidentified_input <= '9') {
            return "number";
        } else if ((unidentified_input >= 'A' && unidentified_input <= 'Z')
                || (unidentified_input >= 'a' && unidentified_input <= 'z')) {
            return "letter";
        } else if (unidentified_input == '_') {
            return "letter";
        }
        for (int i = 0; i < 24; i++) {
            if (unidentified_input == symbol_list[i]) {
                return "symbol";
            }
        }
        return "unknown";
    }
}