public static void clearScreen(){
        String os = System.getProperty("os.name");
        if (os.contains("Windows"))
        {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
        else
        {
            System.out.print("\033\143");
        }
    }