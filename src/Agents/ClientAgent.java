
package Agents;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.Map;

public class ClientAgent extends GuiAgent{

    ClientInterface gui; 
    private AID[] buyersList;
    
        
	@Override
	protected void setup() {
             Object[]args=getArguments();
             String book=(String) args[0];
             String myAmmount=(String) args[1];
            
            gui=new ClientInterface();
	    gui.setVisible(true);
            gui.setClientAgent(this);
            gui.showMessage("my Ammount: "+myAmmount, true);
             gui.showMessage("the book i wanna buy: "+book, true);
            
           System.out.println("hello "+this.getAID().getName());

            
             ParallelBehaviour parallelBehaviour=new ParallelBehaviour();
                addBehaviour(parallelBehaviour);
                parallelBehaviour.addSubBehaviour(new CyclicBehaviour(){
                
           
                    @Override
                    public void action() {
                       
                        MessageTemplate template=
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
                        );
                        
                        ACLMessage message = receive();
                      if(message!=null){
                         
                         gui.showMessage("FROM:"+message.getSender(),true);  
                        // gui.showMessage("id:"+message.getConversationId(),true);  
                         gui.showMessage("TYPE :"+ACLMessage.getPerformative(message.getPerformative()),true);
                         gui.showMessage("OBJECT :"+message.getOntology(),true);
                         gui.showMessage("Message:"+message.getContent(),true);  
                         gui.showMessage("Language :"+message.getLanguage(),true);
                       
                        } 
                        else
                        {
                          block();
                        }
                        
                      }       
                });
            
            parallelBehaviour.addSubBehaviour(new OneShotBehaviour(){
                     

                    @Override
                    public void action() {
                       // Update the list of seller agents
                     DFAgentDescription dfa = new DFAgentDescription();
                     ServiceDescription sd = new ServiceDescription();
                     sd.setType("book buying");
                     dfa.addServices(sd);
                    try
                    {
                      DFAgentDescription[] ad = DFService.search(myAgent, dfa);
                      buyersList = new AID[ad.length];
                      for(int i = 0; i < ad.length; ++i) {
                      buyersList[i] = ad[i].getName();
                       
                       
                       
                        ACLMessage search = new ACLMessage(ACLMessage.CFP);
                        search.addReceiver(new AID("", AID.ISLOCALNAME));
                        search.setContent("buy me a book");
                        search.setOntology("BOOK-TRADING");
                        
                        for(AID aid:buyersList){
                            search.addReceiver(aid);
                    
                       } 
                       
                        send(search);
                      
                      }
                       }
                      catch (FIPAException fe) { fe.printStackTrace(); }

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
             System.out.println("laaaaaaaaaaaaaaaaaaaaa2 "+this.getAID().getName());
	  
	}

    
    
    
        @Override
        protected void onGuiEvent(GuiEvent ge) {
        
            switch (ge.getType()){
           case 1:
              
               Map<String,Object> params = (Map<String,Object>) ge.getParameter(0);
               String bookTitle=(String) params.get("bookTitle");
               String receiverName=(String) params.get("receiverAgent");
               String act=(String) params.get("act");
               
               ACLMessage message = new ACLMessage();
               message.addReceiver(new AID(receiverName, AID.ISLOCALNAME));
               message.setContent(bookTitle);
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
