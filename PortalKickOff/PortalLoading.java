package PortalKickOff;

import java.util.concurrent.TimeUnit;

import ServerMessages.ServerMessages;

public class PortalLoading {

    ServerMessages serverMessages = new ServerMessages();

    private int dots;

    private long delay;

    public PortalLoading(int dots, long delay) {

        this.dots = dots;

        this.delay = delay;

    }

    public void loading() {

        System.out.println("\n" + serverMessages.processRequest());

        System.out.println();

        for (int i = 1; i <= dots; i++) {

            try {

                StringBuilder animation = new StringBuilder("Loading ");

                for (int j = 0; j < i; j++) {
                    animation.append(".");
                }

                System.out.print("\r" + animation.toString());

                System.out.flush();

                TimeUnit.MILLISECONDS.sleep(delay);

            } catch (InterruptedException e) {

                System.out.println("\nAnimation interrupted!");

                Thread.currentThread().interrupt();

            }

        }

        System.out.println();
    }
}