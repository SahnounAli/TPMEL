
package Agents;

import jade.core.AID;
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

public class BuyerAgent extends GuiAgent {

     private AID[] sellersList;
     BuyerInterface gui;         

	
	@Override
	protected void setup() {
                
               
                gui=new BuyerInterface();
		gui.setVisible(true);
                gui.setBuyerAgent(this);
		
		System.out.println("hello "+this.getAID().getName());
	
                ParallelBehaviour parallelBehaviour=new ParallelBehaviour();
                addBehaviour(parallelBehaviour);
                parallelBehaviour.addSubBehaviour(new CyclicBehaviour(){
                    
                    @Override
                    public void action() {
                       //fitrage des message par act
                       /* MessageTemplate template=
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
                        
                       //waiting for messages
                        ACLMessage message = receive();
                        if(message!=null){
                         gui.showMessage("FROM:"+message.getSender(),true);  
                         gui.showMessage("TYPE :"+ACLMessage.getPerformative(message.getPerformative()),true);
                         gui.showMessage("OBJECT :"+message.getOntology(),true);
                         gui.showMessage("Message:"+message.getContent(),true);  
                         gui.showMessage("Language :"+message.getLanguage(),true);
                         
                         
                         //generate reply
                         /* ACLMessage reply = message.createReply();
                         reply.setPerformative(ACLMessage.INFORM);
                         reply.setContent("received");
                         reply.setOntology("BOOK-TRADING-REPLY");
                         send(reply);*/
                         
                         
                        //send call for proposal to all the sellers
                        if(ACLMessage.getPerformative(message.getPerformative())=="REQUEST"){
                        ACLMessage search = new ACLMessage(ACLMessage.CFP);
                        search.addReceiver(new AID("", AID.ISLOCALNAME));
                        search.setContent(message.getContent());
                        search.setOntology(message.getOntology());
                        
                        for(AID aid:sellersList){
                            search.addReceiver(aid);
                    
                       } 
                       
                        send(search);}
                        
                         
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
                       sd.setType("book buying");
                       sd.setName("book trading-buy ");
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
                
                parallelBehaviour.addSubBehaviour(new TickerBehaviour(this,10000){
                     

                    @Override
                    protected void onTick() {
                       // Update the list of seller agents
                     DFAgentDescription dfa = new DFAgentDescription();
                     ServiceDescription sd = new ServiceDescription();
                     sd.setType("book selling");
                     dfa.addServices(sd);
                    try
                    {
                      DFAgentDescription[] ad = DFService.search(myAgent, dfa);
                      sellersList = new AID[ad.length];
                      for(int i = 0; i < ad.length; ++i) {
                      sellersList[i] = ad[i].getName();
                    
                      
                      }
                       }
                      catch (FIPAException fe) { fe.printStackTrace(); 
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
               String bookTitle=(String) params.get("bookTitle");
               String receiverName=(String) params.get("receiverAgent");
               String act=(String) params.get("act");
               
               ACLMessage message = new ACLMessage();
               message.addReceiver(new AID(receiverName, AID.ISLOCALNAME));
               message.setContent(bookTitle);
               message.setOntology("BOOK-TRADING");
               message.setLanguage("english");
               //to set the message performative from interface
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
    
    }}
