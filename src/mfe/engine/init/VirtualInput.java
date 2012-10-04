package mfe.engine.init;

public class VirtualInput
{
    public static boolean[] keys = new boolean[Controller.TOTAL_CONTROLS];
    
    public static void setKeyStates(boolean[] newKeys)
    {
        keys = newKeys;
    }
    
    public static boolean getKeyState(int num)
    {
        return keys[num];
    }
}
