
package Agents;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Map;


public class SellerAgent extends GuiAgent {
    
      SellerInterface gui;  
    
        
	@Override
	protected void setup() {
             
            gui=new SellerInterface();
	    gui.setVisible(true);
            gui.setSellerAgent(this);
            
            System.out.println("hello "+this.getAID().getName());

                          
 ParallelBehaviour parallelBehaviour=new ParallelBehaviour();
                addBehaviour(parallelBehaviour);
                parallelBehaviour.addSubBehaviour(new CyclicBehaviour(){
                   
                    @Override
                    public void action() {
                       
                        /*MessageTemplate template=
                        MessageTemplate.or(
	                MessageTemplate.MatchPerformative(ACLMessage.INFORM), 
	                MessageTemplate.MatchPerformative(ACLMessage.REQUEST));
                        MessageTemplate.or(
	                MessageTemplate.MatchPerformative(ACLMessage.PROPOSE),
                        MessageTemplate.MatchOntology("BOOK-TRADING")
                        );
                        MessageTemplate.or(
	                MessageTemplate.MatchPerformative(ACLMessage.CONFIRM),
                        MessageTemplate.MatchOntology("BOOK-TRADING-REPLY")
                        );*/
                        
                        ACLMessage message = receive();
                        if(message!=null){
                           
                         gui.showMessage("FROM:"+message.getSender(),true);  
                         gui.showMessage("TYPE :"+ACLMessage.getPerformative(message.getPerformative()),true);
                         gui.showMessage("object :"+message.getOntology(),true);
                         gui.showMessage("Message:"+message.getContent(),true);  
                         gui.showMessage("Language :"+message.getLanguage(),true);
                       
                         
                         ACLMessage reply = message.createReply();
                         reply.setPerformative(ACLMessage.INFORM);
                         reply.setContent("received");
                         reply.setOntology("BOOK-TRADING-REPLY");
                         send(reply);
                         
                         
                        }
                        else
                        {
                          block();
                        }}       
                });
                
                parallelBehaviour.addSubBehaviour(new OneShotBehaviour(){
                    @Override
                    public void action() {
                        
                       DFAgentDescription dfd = new DFAgentDescription();
                       dfd.setName(getAID());
                       ServiceDescription sd = new ServiceDescription();
                       sd.setType("book selling");
                       sd.setName("book trading-SALE ");
                       dfd.addServices(sd);
                       try
                       {
                        DFService.register(myAgent, dfd);
                       
                       }
                       catch (FIPAException fe) {
                        fe.printStackTrace();
                        }
    
                    }
            
        });
	
        
        }
        
        @Override
	protected void beforeMove() {
            
             System.out.println("ani hna "+this.getAID().getName());
	
	}
	
	@Override
	protected void afterMove() {
             System.out.println("ani lhih "+this.getAID().getName());
	
	}
	
        
        
        
        @Override
	protected void takeDown() {
            
            // Deregister from the yellow pages
            try
            {
             DFService.deregister(this);
            }
            catch (FIPAException fe) {
            fe.printStackTrace();
            } 
	
	}

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        
        switch (ge.getType()){
           case 1:
              
               Map<String,Object> params = (Map<String,Object>) ge.getParameter(0);
               String price=(String) params.get("price");
               String receiverName=(String) params.get("receiverAgent");
               String act= (String) params.get("act");
               
               ACLMessage message = new ACLMessage();
               message.addReceiver(new AID(receiverName, AID.ISLOCALNAME));
               message.setContent(price);
               message.setOntology("BOOK-TRADING");
               message.setLanguage("english");
               
               switch (act){
                   case "accept proposal": message.setPerformative(0);
                   break;
                   case "agree": message.setPerformative(1);
                   break;
                   case "cancel": message.setPerformative(2);
                   break;
                   case "cfp": message.setPerformative(3);
                   break;
                   case "confirm": message.setPerformative(4);
                   break;
                   case "disconfirm": message.setPerformative(5);
                   break;
                   case "inform": message.setPerformative(7);
                   break;
                   case "propose": message.setPerformative(11);
                   break;
                   case "refuse": message.setPerformative(14);
                   break;
                   case "request": message.setPerformative(16);
                   break;
                   
               }
               
                
              
               
               send(message);



       }
       
    }
    
}
