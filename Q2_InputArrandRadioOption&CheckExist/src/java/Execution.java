/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anngu
 */
public class Execution {

    String array;   
    String option;  
    int result;    

    public Execution() {
    }

    public Execution(String array, String option, int result) {
        this.array = array;
        this.option = option;
        this.result = result;
    }

    public String getArray() {
        return array;
    }

    public String getOption() {
        return option;
    }

    public int getResult() {
        return result;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setResult(int result) {
        this.result = result;
    }
    
    
}
