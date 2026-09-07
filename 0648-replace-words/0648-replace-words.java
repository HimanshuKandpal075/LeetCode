class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String sent = sentence;
        String[] ch = sentence.split(" ");

        for(int i=0;i<dictionary.size();i++){
            for(int j=0;j<ch.length;j++){
                if(ch[j].startsWith(dictionary.get(i))){
                    ch[j] = dictionary.get(i);
                }
            }
        }
        return String.join(" ", ch);
    }
}