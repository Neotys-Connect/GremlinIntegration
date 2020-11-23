package com.neotys.gremlin.common.datamodel.jsonattack;


import java.util.ArrayList;
import java.util.List;

public class AttackJson {

    List<GremlinAttackAttack> gremlinAttack=new ArrayList<>();

    public AttackJson(List<GremlinAttackAttack> gremlinAttack) {
        this.gremlinAttack = gremlinAttack;
    }

    public List<GremlinAttackAttack> getGremlinAttack() {
        return gremlinAttack;
    }

    public void setGremlinAttack(List<GremlinAttackAttack> gremlinAttack) {
        this.gremlinAttack = gremlinAttack;
    }

    public String validateModel()
    {

        StringBuilder errormessage=new StringBuilder();
        gremlinAttack.stream().forEach(gremlinAttackAttack -> {
            if(gremlinAttackAttack.getGremlinTarget()==null && gremlinAttackAttack.getGremlinCommand()==null)
            {
                if(gremlinAttackAttack.getDelay()==null)
                    errormessage.append("Delay needs to exists if the target and the command is not defined\n");
            }
            else
            {
                if(gremlinAttackAttack.getGremlinTarget()!=null)
                {
                    if(gremlinAttackAttack.getGremlinCommand()!=null)
                    {
                        //controlling the content of the attack
                        GremlinTarget target=gremlinAttackAttack.getGremlinTarget();
                        if(target.getSelectionType()==null)
                            errormessage.append("An attack needs to have target selection type defined\n");

                        if(target.getType()==null)
                            errormessage.append("The type of target needs to be defined\n");

                        if( target.getTags().size()==0)
                            errormessage.append("The target needs to have at least one tag defined\n");

                        if(target.getNumberOfSelection()==null || target.getNumberOfSelection().intValue()==0)
                            errormessage.append("The target needs to have number defined\n");

                        GremlinCommand command=gremlinAttackAttack.getGremlinCommand();
                        if(command.getCommandType()==null)
                            errormessage.append("The command type needs to be defined ");

                        if(command.getArgs().size()==0)
                            errormessage.append("The command requries to have args defined");

                    }
                    else
                        errormessage.append("Your attack needs to have a command defined\n");
                }
                else
                    errormessage.append("You need to define the target of your attack\n");
            }
        });

        return errormessage.toString();
    }
}
