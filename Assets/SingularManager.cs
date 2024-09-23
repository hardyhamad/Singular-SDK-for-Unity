using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Singular;
public class SingularManager : MonoBehaviour
{
   public void OnClickPlay()
    {
        SingularSDK.Event("GamePlaying");
        print("GamePlaying");
    }
    public void OnClickRemoveADs()
    {
        SingularSDK.Event("Removing Ads", "RemoveAds", 1);
    }
    public void OnClickPurchaseCoins(int Coins)
    {
        if (Coins == 450)
        {
            SingularSDK.Event($"Purchased {Coins} Coins", "Coins", Coins, "Price$", 1.1);
            SingularSDK.CustomRevenue("MyCustomRevenue", "USD", 1.10);
        }
        else if (Coins == 1000)
        {
            SingularSDK.Event($"Purchased {Coins} Coins", "Coins", Coins, "Price$", 2.9);
            SingularSDK.CustomRevenue("MyCustomRevenue", "USD", 2.90);
        }

    }
}
