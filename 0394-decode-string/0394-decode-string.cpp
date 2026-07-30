class Solution {
public:
    string decodeString(string s) {
        stack<pair<string, int>> st;
        string currString = "";
        int currNum = 0;
        for (char ch : s) {
            if (isdigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }
            else if (ch == '[') {
                st.push({currString, currNum});
                currString = "";
                currNum = 0;
            }
            else if (ch == ']') {
                auto [prevString, repeat] = st.top();
                st.pop();
                string temp = "";
                while (repeat--) {
                    temp += currString;
                     }
                currString = prevString + temp;
            }
            else {
                currString += ch;
            }
        }
        return currString;
    }
};