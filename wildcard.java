public class wildcard {
    
    public static boolean Solve ( String s , String t , int i , int j ) {

        if ( i < 0 && j < 0 )
            return true;
        
        else if ( i < 0 && j > 0 )
            return false;
        
        else if ( i > 0 && j < 0 ) {

            for ( int in = 0 ;  in <= i ; i++ ) {

                if ( t.charAt(in) != '*' )
                    return false;
            }
            return true;
        }

        if ( s.charAt( i ) == t.charAt(j) || t.charAt(j) == '?')
            return Solve ( s , t , i - 1 , j - 1 );
        
        else if ( t.charAt(j) == '*' )
            return Solve ( s , t , i , j - 1 ) || Solve ( s , t , i - 1 , j );
        
        else
            return false;
    }
    public static boolean Match ( String s , String t ) {

        int n = s.length();
        int m = t.length();

        return Solve ( s , t , n - 1 , m - 1 );
    }
    public static void main(String[] args) {
        
        String s = "abcde";
        String t = "a?c*";

        boolean match = Match ( s , t );

        if ( match == true )
            System.out.println("matched");
        else 
            System.out.println("not matched");
    }

}
