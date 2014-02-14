import java.io.File;




public class Racer extends Thread
{
   public static void main(String[] arg)
   {
      new Racer(true).start();
      new Racer(false).start();
   }


   
   private int mFileNumber;
   boolean mCreator;
   
   public File newFile(int number)
   {
      return new File(String.format("file.%05d", number));
      
   }
   public Racer(boolean pCreator)
   {
      this.mCreator = pCreator;
      this.mFileNumber = 0;
   }

   public void run()
   {
      while(true)
      {
         try
         {
            if(mCreator)
            {
               if(newFile(mFileNumber).createNewFile())
               {
                  mFileNumber++;
               }
            }
            else
            {
               if(newFile(mFileNumber).delete())
               {
                  mFileNumber++;
               }
            }
            Thread.sleep(500);
         }
         catch (Exception e)
         {
            
         }
      }

   }
}