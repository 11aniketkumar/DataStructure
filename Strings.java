class Strings{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Tony");

        System.out.println(sb);

        //char at index 0
        System.out.println(sb.charAt(0));

        //set char at index 0
        sb.setCharAt(0, 'P');
        System.out.println(sb);

        //insert
        sb.insert(0, 'S');
        System.out.println(sb);
        sb.insert(3, 'o');
        System.out.println(sb);

        //delete string part
        sb.delete(5,6);
        System.out.println(sb);
        sb.delete(1,2);
        System.out.println(sb);

        //append
        sb.append(" Toon");
        System.out.println(sb);

        //length
        System.out.println(sb.length());

        //delete char
        sb.deleteCharAt(1);
        System.out.println(sb);
    }
}