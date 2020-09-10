// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EventConfig.java

package com.gamerforea.galacticraft;

import com.gamerforea.eventhelper.util.FastUtils;
import java.io.PrintStream;
import net.minecraftforge.common.config.Configuration;

public final class EventConfig
{

    public EventConfig()
    {
    }

    public static void init()
    {
        try
        {
            Configuration cfg = FastUtils.getConfig("GalactiCraft");
            String c = "general";
            keepInvEnabled = cfg.getBoolean("keepInvEnabled", c, keepInvEnabled, "\u0412\u043A\u043B\u044E\u0447\u0438\u0442\u044C \u0441\u043E\u0445\u0440\u0430\u043D\u0435\u043D\u0438\u0435 \u0438\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u044F \u043F\u043E\u0441\u043B\u0435 \u0441\u043C\u0435\u0440\u0442\u0438");
            keepInvPerm = cfg.getString("keepInvPerm", c, keepInvPerm, "\u0420\u0430\u0437\u0440\u0435\u0448\u0435\u043D\u0438\u0435 \u043D\u0430 \u0441\u043E\u0445\u0440\u0430\u043D\u0435\u043D\u0438\u0435 \u0438\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u044F \u043F\u043E\u0441\u043B\u0435 \u0441\u043C\u0435\u0440\u0442\u0438");
            stationNeedPerm = cfg.getBoolean("stationNeedPerm", c, stationNeedPerm, "\u0412\u043A\u043B\u044E\u0447\u0438\u0442\u044C \u043F\u0440\u043E\u0432\u0435\u0440\u043A\u0443 \u043F\u0440\u0430\u0432 \u043F\u0440\u0438 \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u0438 \u0441\u0442\u0430\u043D\u0446\u0438\u0438");
            stationPerm = cfg.getString("stationPerm", c, stationPerm, "\u0420\u0430\u0437\u0440\u0435\u0448\u0435\u043D\u0438\u0435 \u043D\u0430 \u0441\u043E\u0437\u0434\u0430\u043D\u0438\u0435 \u0441\u0442\u0430\u043D\u0446\u0438\u0438");
            fixSchematicsDeathClear = cfg.getBoolean("fixSchematicsDeathClear", c, fixSchematicsDeathClear, "\u0418\u0441\u043F\u0440\u0430\u0432\u0438\u0442\u044C \u0441\u0431\u0440\u043E\u0441 \u0441\u0445\u0435\u043C \u0412\u0435\u0440\u0441\u0442\u0430\u043A\u0430 NASA \u043F\u0440\u0438 \u0441\u043C\u0435\u0440\u0442\u0438 \u0438\u0433\u0440\u043E\u043A\u0430");
            fixBossDupe = cfg.getBoolean("fixBossDupe", c, fixBossDupe, "\u0418\u0441\u043F\u0440\u0430\u0432\u0438\u0442\u044C \u0434\u044E\u043F \u0434\u0440\u043E\u043F\u0430 \u0431\u043E\u0441\u0441\u043E\u0432");
            addRocketToInvInsteadSpawn = cfg.getBoolean("addRocketToInvInsteadSpawn", c, addRocketToInvInsteadSpawn, "\u041F\u0440\u0438 \u043F\u0435\u0440\u0435\u043B\u0451\u0442\u0435 \u043D\u0430 \u0434\u0440\u0443\u0433\u0443\u044E \u043F\u043B\u0430\u043D\u0435\u0442\u0443/\u043B\u0443\u043D\u0443 \u043F\u043E\u043C\u0435\u0449\u0430\u0442\u044C \u0432\u0441\u0435 \u043F\u0440\u0435\u0434\u043C\u0435\u0442\u044B \u0432 \u0438\u043D\u0432\u0435\u043D\u0442\u0430\u0440\u044C \u0438\u0433\u0440\u043E\u043A\u0430");
            teleportDebug = cfg.getBoolean("teleportDebug", c, teleportDebug, "\u0412\u044B\u0432\u043E\u0434 \u043E\u0442\u043B\u0430\u0434\u043E\u0447\u043D\u043E\u0439 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u0438 \u043F\u0440\u0438 \u0437\u0430\u043F\u0440\u0435\u0442\u0435 \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430\u0446\u0438\u0438");
            teleportCheckTier = cfg.getBoolean("teleportCheckTier", c, teleportCheckTier, "\u041F\u0440\u043E\u0432\u0435\u0440\u044F\u0442\u044C Tier \u0440\u0430\u043A\u0435\u0442\u044B \u0438\u0433\u0440\u043E\u043A\u0430 \u043F\u0440\u0438 \u043F\u043E\u043F\u044B\u0442\u043A\u0435 \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430\u0446\u0438\u0438 \u043D\u0430 \u0434\u0440\u0443\u0433\u043E\u0435 \u043D\u0435\u0431\u0435\u0441\u043D\u043E\u0435 \u0442\u0435\u043B\u043E");
            rocketLaunchFlame = cfg.getBoolean("rocketLaunchFlame", c, rocketLaunchFlame, "\u041F\u043E\u0434\u0436\u0438\u0433\u0430\u043D\u0438\u0435 \u043C\u043E\u0431\u043E\u0432 \u043E\u0433\u043D\u0451\u043C \u043F\u0440\u0438 \u0432\u0437\u043B\u0451\u0442\u0435 \u0440\u0430\u043A\u0435\u0442\u044B");
            cfg.save();
        }
        catch(Throwable throwable)
        {
            System.err.println("Failed load config. Use default values.");
            throwable.printStackTrace();
        }
    }

    public static boolean keepInvEnabled = true;
    public static String keepInvPerm = "galacticraft.keepinv";
    public static boolean stationNeedPerm = false;
    public static String stationPerm = "galacticraft.createstation";
    public static boolean fixSchematicsDeathClear = true;
    public static boolean fixBossDupe = true;
    public static boolean addRocketToInvInsteadSpawn = false;
    public static boolean teleportDebug = false;
    public static boolean teleportCheckTier = true;
    public static boolean rocketLaunchFlame = false;

}
