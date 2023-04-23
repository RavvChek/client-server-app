package ru.ravvcheck.itmo.springLabs.commands;

import ru.ravvcheck.itmo.springLabs.exceptions.WrongValuesException;
import ru.ravvcheck.itmo.springLabs.model.SpaceMarine;
import ru.ravvcheck.itmo.springLabs.supervisor.Supervisor;

public class RemoveByIdCommand extends AbstractCommand {
    public RemoveByIdCommand(Supervisor supervisor) {
        super("remove", "Удалить элемент из коллекции по его id", supervisor);
    }

    @Override
    public void execute(String args) throws WrongValuesException {
        try {
            int id = Integer.parseInt(args);
            if(this.haveId(id)){
                supervisor.getDatabase().removeByIdItem(id);
            }
            else{
                System.out.println("Объект с таким id не найден");
            }
        } catch (NumberFormatException e) {
            System.out.println("Поле id должно быть integer");
        }
    }
}
