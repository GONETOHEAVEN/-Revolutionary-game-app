package ru.itschool.textquest;

public class Story {
    public Situation currentSituation;
    private Situation startStory;
    private Character manager;

    Story(Character manager) {
        this.manager = manager;
        startStory = new Situation(
                "Первая сделка (Windows)",
                "Итак, вас зовут " + manager.name + ".\n\nТолько вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.\n\n"
                        + "(1) У клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр;\n"
                        + "(2) Чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр;\n"
                        + "(3) Как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр."
                +"(4)  выписать чек клиенту на Pro, Ultimate и Home версии Windows на сумму 200 000 т.руб",
                 4, 0, 0, 0);
        startStory.direction[0] = new Situation(
                "Корпоратив",
                "Неудачное начало, ну что ж, сегодня в конторе корпоратив! "
                        + "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу...\n\n"
                        + "(1) Пообщаться с программистом;\n"
                        + "(2) Пообщаться с менеджером;\n"
                        + "(3) Пообщаться с охранником;\n",
                3, 0, -10, -10);
        startStory.direction[0].direction[0] = new Situation(
              " Ghbstn",
                "2eat",
                0,0,0,0);

        startStory.direction[1] = new Situation(
                "Совещание, босс доволен",
                "Сегодня будет совещание, меня неожиданно вызвали,"
                        + "есть сведения, что босс доволен сегодняшней сделкой."
                +"Босс выпишет мне премию в размере 5 000 т.руб" ,
                0, 1, 100, 0);
        startStory.direction[2] = new Situation(
                "Мой первый лояльный клиент",
                "Мой первый клиент доволен скоростью и качеством "
                        + "моей работы. Сейчас мне звонил лично директор компании, сообщил что скоро состоится еще более крупная сделка"
                        + " и он хотел, чтобы по ней работал именно я!", 0, 0,
                50, 1);
        startStory.direction[3] = new Situation("Успех!",
                "Наш босс устроил вечеринку в честь этого события!"
                + " Первый клиент обогатил нашу компанию! ",
                0 , 2,500,5

        );
        currentSituation = startStory;


    }

    public void go(int num) {
        if (num <= currentSituation.direction.length)
            currentSituation = currentSituation.direction[num];
        else
            System.out.println("Вы можете выбирать из " +
                    currentSituation.direction.length + " вариантов");
    }

    public int getDirectionsLength() {
        return currentSituation.direction.length;
    }

    public boolean isEnd() {
        return currentSituation.direction.length == 0;
    }
}
