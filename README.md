# Android_CustomizedListView_Demo
It is a simple Demo that customized the list view so that it can show a view including images,texts.
When user click one of thses views in the list view, it will prompt user by dialog. In the dialog there will be a Edit Text view showing 
the choosed item name.User can change the item in the dialog.The Changed item also will be reflected into the list view.

# Structrue of Source Code
1.There are 5 classes besides MainActivity.java. They are WifiInformation,WifiListAdapter,WifiNameModifier,WifiSecurity,WifiState, respectively.
#WifiInformation
  As mentioned at start, this is a simple one-activity app showing a list of wifi information. So, here, I abstract wifi infromation into WifiInformation class.In this class, it includs wifiName of String type, wifiState and kinOfSecurity of int type, and isBlocked of boolean type.
  wifiName shows the name of each wifi device，wifiState shows intensity of each wifi device, kindOfSecurity shows their security police, isBlocked shows if it is blocked or not.
  Also, in this class, it includes getter and setter functions.

#WifiListAdapter
  WifiListAdapter is a subclass of ArrayAdatper, that is because ArrayAdapter  is too simple to show complex views. So, here i chose to extends ArrayAdapter. 
  WifiListAdapter has a list of WifiInformation objects. The important thing is that we have to override the getView method inherited from ArrayAdapter.This method is a rendering method that is in charge of getting the souce data showing on the view, structurely.

