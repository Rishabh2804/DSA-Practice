class Solution {
    static final char SLASH = '/';
    static final String CURR_DIR = ".";
    static final String PAR_DIR = "..";
    
    public String simplifyPath(String path) {
                
        Stack<String> dirs = new Stack<>();
        int si = 1;
        int ei = 1;
        while(ei < path.length()){
            if(path.charAt(ei) == SLASH){
                String dir = path.substring(si, ei);
                if(dir.length() > 0){
                    if(dir.equals(PAR_DIR)){
                        if(!dirs.isEmpty()) dirs.pop();
                    } else if(!dir.equals(CURR_DIR))
                        dirs.push(dir);                            
                }
                
                si = ei + 1;
            }
            
            ei++;
        }

        String dir = path.substring(si, ei);
        if(dir.length() > 0){
            if(dir.equals(PAR_DIR)){
                if(!dirs.isEmpty()) dirs.pop();
            } else if(!dir.equals(CURR_DIR))
                dirs.push(dir);                            
        }
        
        Stack<String> cst = new Stack<>();        
        while(!dirs.isEmpty())
            cst.push(dirs.pop());
        
        StringBuilder canonPath = new StringBuilder();
        while(!cst.isEmpty()){
            canonPath.append(SLASH);
            canonPath.append(cst.pop());
        }
        
        if(canonPath.length() == 0)
            return "/";
        else return canonPath.toString();
    }
}