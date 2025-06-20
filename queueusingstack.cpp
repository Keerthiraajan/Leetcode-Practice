#include <iostream>
#include <stack>
using namespace std;

class MyQueue {
public:
    stack<int> input, output;

    MyQueue() {}

    void push(int x) {
        input.push(x);
    }

    int pop() {
        if (!output.empty()) {
            int t = output.top();
            output.pop();
            return t;
        } else {
            int n = input.size();
            for (int i = 0; i < n; i++) {
                int temp = input.top();
                output.push(temp);
                input.pop();
            }
            int re = output.top();
            output.pop();
            return re;
        }
    }

    int peek() {
        if (!output.empty())
            return output.top();
        else {
            int n = input.size();
            for (int i = 0; i < n; i++) {
                int temp = input.top();
                output.push(temp);
                input.pop();
            }
            return output.top();
        }
    }

    bool empty() {
        return input.empty() && output.empty();
    }
};

int main() {
    MyQueue obj;
    obj.push(10);
    obj.push(20);
    cout << obj.peek() << endl;
    cout << obj.pop() << endl;
    cout << obj.empty() << endl;
    return 0;
}
