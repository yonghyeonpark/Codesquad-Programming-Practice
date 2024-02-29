public enum Code {

    _0(0, "0"),
    _1(1, "1"),
    _2(2, "2"),
    _3(3, "3"),
    _4(4, "4"),
    _5(5, "5"),
    _6(6, "6"),
    _7(7, "7"),
    _8(8, "8"),
    _9(9, "9"),
    A(10, "A"),
    B(11, "B"),
    C(12, "C"),
    D(13, "D"),
    E(14, "E"),
    F(15, "F"),
    G(16, "G"),
    H(17, "H"),
    I(18, "I"),
    J(19, "J"),
    K(20, "K"),
    L(21, "L"),
    M(22, "M"),
    N(23, "N"),
    O(24, "O"),
    P(25, "P"),
    Q(26, "Q"),
    R(27, "R"),
    S(28, "S"),
    T(29, "T"),
    U(30, "U"),
    V(31, "V"),
    W(32, "W"),
    X(33, "X"),
    Y(34, "Y"),
    Z(35, "Z"),
    SPACE(36, " "),
    DOLLAR(37, "$"),
    PERCENT(38, "%"),
    ASTERISK(39, "*"),
    PLUS(40, "+"),
    HYPHEN(41, "-"),
    DOT(42, "."),
    SLASH(43, "/"),
    COLON(44, ":");

    private int code;
    private String character;

    Code(int code, String character) {
        this.code = code;
        this.character = character;
    }

    public int getCode() {
        return code;
    }

    public String getCharacter() {
        return character;
    }
}
