#include<bits/stdc++.h>
using namespace std;

vector < int > findNSE ( vector < int > arr , int n ) {

    stack < int > st ; 
    vector < int > ans ( n ); 

    for ( int i = n - 1 ; i >= 0 ; i-- ) {

        while ( !st.empty() && arr[ st.top() ] >= arr[ i ] )
            st.pop();
        
        if ( st.empty() )
            ans[ i ] = n ;
        
        else
            ans[ i ] =  st.top() ;
        
        st.push ( i );
    }

    return ans ; 
}

vector < int > findPSE ( vector < int > arr , int n ) {
    
    stack < int > st ; 
    vector < int > ans ( n ); 

    for ( int i = 0 ; i < n ; i++ ) {

        while ( !st.empty() && arr[ st.top() ] >= arr[ i ] )
            st.pop();
        
        if ( st.empty() )
            ans[ i ] = -1 ;
        
        else
            ans[ i ] =  st.top()  ;
        
        st.push (  i  );
    }

    return ans ; 

}

int largestAreaInHistogram( vector< int > &arr ) {

    int n = arr.size();

    vector<int> nse = findNSE(arr, n);
    vector<int> pse = findPSE(arr, n);

    int maxArea = 0;

    for ( int i = 0; i < n; i++) {

        int width = nse[i] - pse[i] - 1;
        int area = arr[i] * width;
        maxArea = max(maxArea, area);
    }

    return maxArea;
}


int main() {

    vector<int> arr = {7, 2, 8, 9, 1, 3, 6, 5};
    cout << "Largest Rectangle Area in Histogram: " << largestAreaInHistogram(arr) << endl;
    return 0;


}