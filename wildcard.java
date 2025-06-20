public class wildcard {
    
    public static boolean Match ( String s , String t ) {

        int n = s.length();
        int m = t.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        
        dp[ 0 ][ 0 ] = true;

        for ( int j = 1 ; j <= m ; j++ ) {

            if ( t.charAt( j - 1 ) == '*' )
                dp[ 0 ][ j ] = dp[ 0 ][ j - 1 ];
            else   
                dp[ 0 ][ j ] = false;
        }
        
        for ( int i = 1 ; i <= n ; i++ ) {

            for ( int j = 1 ; j <= m ; j++ ) {

                if ( s.charAt( i - 1 ) == t.charAt(j - 1) || t.charAt(j - 1) == '?')
                    dp[ i ][ j ] = dp[ i - 1 ][ j - 1];
                
                else if ( t.charAt( j - 1 ) == '*' )
                    dp[ i ][ j ] = dp[ i ][ j - 1 ]|| dp[ i - 1 ][ j ];
                else
                    dp[ i ][ j ] = false;
            }
        }

        return dp[ n ][ m ];
    }
    public static void main(String[] args) {
        
        String s = "aa";
        String t = "?";

        boolean match = Match ( s , t );

        if ( match == true )
            System.out.println("matched");
        else 
            System.out.println("not matched");
    }

}
