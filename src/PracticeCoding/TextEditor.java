package PracticeCoding;

import java.util.LinkedList;
import java.util.Stack;

public class TextEditor {
    private Character head;
    private Character current;
    private Stack<Command> stack = new Stack<>();

    public boolean moveCursorLeft(){
        if(current.prev == null)
            return false;
        current = current.prev;
        return true;
    }

    public boolean moveCursorRight(){
        if(current.next == null)
            return false;
        current = current.next;
        return true;
    }

    public boolean insertCharacter(char c){

        Character character = new Character(current, c, current == null? current.next : head);

        if(current.next != null) {
            current.next.prev = character;
        }
        current.next = character;
        current = character;
        if(head == null){
            head = character;
        }
        return true;
    }


    public boolean backspace(){
        if(current == null)
            return false;

        Character ch = current;
        if(ch.prev != null){
            ch.prev.next = current.next;

        }
        ch.next = null;
        ch.next.prev = ch.prev;
        current = ch.prev;
        ch.prev = null;


        return true;
    }

    public void undo(){

    }
}

class Character {
    public char c;
    public Character next;
    public Character prev;

    public Character(Character prev, char c, Character next){
        this.c = c;
        this.prev = prev;
        this.next = next;
    }

}

interface Command {
    public void execute(LinkedList ll);
    public void undo();
}

class moveCursorLeft implements Command {
    public void execute(LinkedList ll){

    }

    public void undo(){

    }
}

class moveCursorRight implements Command {
    public void execute(LinkedList ll){

    }

    public void undo(){

    }
}

class insertCharacter implements Command {
    public void execute(LinkedList ll){

    }

    public void undo(){

    }
}