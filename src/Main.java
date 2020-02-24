public class Main {

    public static void main(String[] args) {

        Fighter player1 = new Fighter("Cyborg","fatality!!", "fgg" );

        Fighter player2 = new Fighter("Golum", "Get schrecked", "gth" );

        Fighter player3 = new Fighter("Scorpion","Vengeance will be mine!!!", "fgg" );

        Fighter player4 = new Fighter("Sub-zero","I am Reptile, and I do not answer to you. Fight!!!", "fgg" );

        Fighter player5 = new Fighter("Kano", "Get schrecked", "gth" );

        Fighter player6 = new Fighter("Jhonny","Feel the steel!!", "fgg" );

        Fighter player7 = new Fighter("Raiden", "Hahaha!!!", "gth" );

        Fighter player8 = new Fighter("Reptile", "Get reptiled", "gth" );



        Tournament t1 = new Tournament(player1, player2);

        Tournament t2 = new Tournament(player3, player4);

        Tournament t3 = new Tournament(player5, player6);

        Tournament t4 = new Tournament(player7, player8);



        t1.start();

        t2.start();

        t3.start();

        t4.start();





    }




}
