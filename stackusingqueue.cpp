#include <iostream>
#include <queue>
using namespace std;

class MyStack {
public:
    queue<int> st;
    
    MyStack() {}
    
    void push(int x) {
        st.push(x);
        int size = st.size();
        for (int i = 1; i < size; i++) {
            st.push(st.front());
            st.pop();
        }
    }
    
    int pop() {
        int s = st.front();
        st.pop();
        return s;
    }
    
    int top() {
        return st.front();
    }
    
    bool empty() {
        return st.empty();
    }
};

int main() {
    MyStack obj;
    obj.push(10);
    obj.push(20);
    cout << obj.top() << endl;
    cout << obj.pop() << endl;
    cout << obj.empty() << endl;
    return 0;
}
