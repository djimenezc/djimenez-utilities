package com.gowex.sms.sent.example.command;

import com.gowex.patterns.command.Command;

public interface HttpCommand extends Command {

  String getResponse();

}
