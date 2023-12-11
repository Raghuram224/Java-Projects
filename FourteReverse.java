package FourteReverse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class FourteReverse {
    
    int target;
    int[] correctOptions=new int[2];
    int[]options=new int[4];
    char operator;
//    static  int bruteForceCount=0;
    public FourteReverse(int target){
        this.target=target;
    }
    
    public String matchFinder(){      
        Scanner scanner = new Scanner(System.in);
        String answer=" ";

        try {       
                
                System.out.println("Enter your options by comma seprated :");
                String optionsString = scanner.nextLine();
                String[] tempOptions = optionsString.split(",");
                for (int i=0;i< tempOptions.length;i++){
                    options[i]=Integer.parseInt(tempOptions[i]);
                }
                
                if (resultGetter(options)){
                    System.out.println("Answer: "+correctOptions[0]+" "+operator+" "+correctOptions[1]+" = "+target);
                }else {
                    System.out.println("Sorry i couldn't find answer please check your options");
                }


        } catch (Exception e) {

            e.printStackTrace();
        }
        return answer;
    }
    public boolean resultGetter(int[] options){
        boolean isAnswerFound=false;
        ArrayList<Integer> temp;
        int bruteForceCount=0;
        int operatorCheckedCount=1;
      
        
        for(int i=0; i<options.length; i++){
            temp = new ArrayList<>();
            
            for(int j=0; j<options.length; j++){
                if (i == j) continue;
                else temp.add(options[j]);
                
            }
            
            if (bruteForceCount==16){
                break;
            }
            if (isMatchFound(temp, operatorCheckedCount)) {
                isAnswerFound=true;
                break;
            }else {
                bruteForceCount++;
            }
            if (bruteForceCount%4==0){
                operatorCheckedCount++;
//                System.out.println("operator changed");
                i=-1;
               
            }
        }
        return  isAnswerFound;
        
    }

    public boolean isMatchFound(ArrayList<Integer> tempOptions,int operatorCheckedCount){
        boolean isMatchFound=false;

        switch (operatorCheckedCount) {
            case 1:
//                System.out.println("add");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)+tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='+';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            case 2:
//                System.out.println("min");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)-tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='-';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            
            case 3:
//                System.out.println("mul");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)*tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='*';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            case 4:
//                System.out.println("Div");
                for(int i=0;i<tempOptions.size();i++){
                    for(int j=0;j<tempOptions.size();j++){
                        
                        if (tempOptions.get(i)/tempOptions.get(j)==this.target && i!=j) {
                            correctOptions[0]= tempOptions.get(i);
                            correctOptions[1]=tempOptions.get(j);
                            isMatchFound=true;
                            operator='/';
                            return  isMatchFound;
                        }
                    }
                }
                break;
            default:
                break;
        }

        return isMatchFound;
        
    }
   
}
