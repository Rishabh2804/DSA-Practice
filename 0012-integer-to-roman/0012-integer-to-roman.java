class Solution {
        public String intToRoman(int n){
        String ans="";

        while(n>=1000){
            ans+='M';
            n-=1000;

        }
            
        if(n>=900){
            ans+="CM";
            n-=900;
        }

        if(n>=500){
            ans+='D';
            n-=500;
        }

        if(n>=400){
            ans+="CD";
            n-=400;
        }
   
        while(n>=100){
            ans+='C';
            n-=100;
        }
        
        if(n>=90){
            ans+="XC";
            n-=90;
        }

        if(n>=50){
            ans+='L';
            n-=50;
        }

        if(n>=40){
            ans+="XL";
            n-=40;
        }

        while(n>=10){
            ans+='X';
            n-=10;
        }

        if(n>=9){
            ans+="IX";
            n-=9;
        }

        if(n>=5){
            ans+='V';
            n-=5;
        }

        if(n>=4){
            ans+="IV";
            n-=4;
        }

        while(n>=1){
            ans+='I';
            n-=1;
        }
        
        return ans;
    }
}