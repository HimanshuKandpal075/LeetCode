class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for(String s : emails){
            String[] parts = s.split("@");

            String local = parts[0];
            String domain = parts[1];

            StringBuilder ans = new StringBuilder();

            for(char ch: local.toCharArray()){
                if(ch == '+'){
                    break;
                }
                else if(ch == '.'){
                    continue;
                }
                else{
                    ans.append(ch);
                }
            }

            ans.append("@").append(domain);
            set.add(ans.toString());
        }
        return set.size();
    }
}