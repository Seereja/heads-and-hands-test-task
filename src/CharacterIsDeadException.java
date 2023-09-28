
public class CharacterIsDeadException extends RuntimeException {
    public CharacterIsDeadException(String name) {
        super("Персонаж " + name + " мёртв");
    }
}
