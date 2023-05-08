package SpontaneousReplace.Generic;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

/**
 * <b style="color:FFC800"><font size="+2">SRData：自然更替数据</font></b>
 * <p><i><b style="color:FFC800"><font size="+1">负责模组大部分内容可能用到的特殊数据</font></b></i></p>
 * <style="color:FFC800">
 *
 * @author 刘 Saikel Orado 又称 “游戏极客-Saikel”
 * <p>Saikel Orado Liu aka ”GameGeek-Saikel“</p>
 * @version 13.0
 * | 创建于 2022 /11/14 ~ 2022/12/8
 */
public abstract class SRData {
    /**
     * 禁止实例化 SRData 模组数据类
     */
    private SRData() {
        throw new Error("请检查是否实例化 SRData 模组数据类");
    }

    public static final String MOD_ID = "spontaneous_replace";
    public static final String MOD_OFFICIAL_WEB = "https://www.curseforge.com/minecraft/mc-mods/spontaneous-replace";
    public static final String MOD_SUPPORT_WEB = "https://www.patreon.com/GameGeek_Saikel";
    public static final String MOD_SUPPORT_WEB_OF_CN = "https://afdian.net/a/GameGeek_Saikel";
    public static final String MOD_COMMUNITY_WEB = "https://discord.gg/ChRbMFgVw3";
    public static final Item SR_ICON = new Item(new FabricItemSettings());
    public static final int TICK = 20;
    public static final float POS_SHIFTING = 0.5F;
    public static final float PROJECTILE_BOX = 0.25F;
    public static final int PROJECTILE_RANGE = 4;
    public static final int PROJECTILE_UPDATE_RATE = 20;

    /**
     * 玩家数据
     */
    public static abstract class Player {
        /**
         * 禁止实例化 Player 玩家数据类
         */
        private Player() {
            throw new Error("请检查是否实例化 Player 玩家数据类");
        }

        public static final double WALK_SPEED = getVelocitySpeed(4.317);
        public static final double SPRINT_SPEED = getVelocitySpeed(5.612);
        public static final double SNEAK_SPEED = getVelocitySpeed(1.295);
        public static final double FLY_SPEED = getVelocitySpeed(10.89);
        public static final double SPRINT_FLY_SPEED = getVelocitySpeed(21.78);
        public static final double FALL_SPEED = getVelocitySpeed(78.4);

        public static final double SPEED_CONVERSION_RATIO = 3.05;

        /**
         * 获取 Velocity 速度
         *
         * @param metrePerSecond 米/秒
         * @return Velocity 速度
         */
        public static double getVelocitySpeed(double metrePerSecond) {
            return metrePerSecond * SPEED_CONVERSION_RATIO;
        }

        /**
         * 获取 Velocity 速度
         *
         * @param velocity Velocity 加速度参数
         * @return Velocity 速度
         */
        public static double getVelocitySpeed(Vec3d velocity) {
            return Math.sqrt(Math.pow(velocity.getX() * 100, 2) + Math.pow(velocity.getZ() * 100, 2));
        }

        /**
         * 获取米/秒
         *
         * @param velocitySpeed Velocity 速度
         * @return 米/秒
         */
        public static double getMetrePerSecond(double velocitySpeed) {
            return velocitySpeed * SPEED_CONVERSION_RATIO;
        }

        /**
         * 获取使用物品时的视场角缩放倍数
         *
         * @param player        玩家，使用者
         * @param fovMultiplier 原视场角倍数
         * @param srBow         判断使用的弓
         * @param scaleMultiple 缩放倍数
         * @return 使用物品时的当前视场角缩放倍数
         */
        public static float getFovMultiplier(ClientPlayerEntity player, double fovMultiplier, SRBow srBow, double scaleMultiple) {
            ItemStack stack = player.getActiveItem();
            double fovMulti = 1;
            if (player.isSprinting())
                fovMulti = 1.15;
            if (stack.isOf(srBow)) {
                return (float) (fovMultiplier - (fovMultiplier - scaleMultiple * fovMulti)
                        * ((SRBow) stack.getItem()).getPullProgress(stack.getMaxUseTime() - player.getItemUseTimeLeft()));
            }
            return (float) fovMultiplier;
        }

        /**
         * 获取使用物品时的视场角缩放倍数
         *
         * @param player        玩家，使用者
         * @param fovMultiplier 原视场角倍数
         * @param srCrossbow    判断使用的弩
         * @param scaleMultiple 缩放倍数
         * @return 使用物品时的当前视场角缩放倍数
         */
        public static float getFovMultiplier(ClientPlayerEntity player, double fovMultiplier, SRCrossbow srCrossbow, double scaleMultiple) {
            ItemStack stack = player.getMainHandStack();
            if (!stack.isOf(srCrossbow))
                stack = player.getOffHandStack();
            double fovMulti = 1;
            if (player.isSprinting())
                fovMulti = 1.15;
            if (stack.isOf(srCrossbow) && SRCrossbow.isCharged(stack)) {
                return (float) (fovMultiplier - (fovMultiplier - scaleMultiple * fovMulti));
            }
            return (float) fovMultiplier;
        }
    }

    /**
     * 获取游戏刻
     *
     * @param seconds 所需秒数
     * @return Minecraft 游戏刻
     */
    public static int getTick(double seconds) {
        return (int) (seconds * TICK);
    }

    /**
     * 获取秒数
     *
     * @param ticks 所需秒数
     * @return Minecraft 游戏刻
     */
    public static float getSeconds(double ticks) {
        return (float) (ticks / TICK);
    }

    /**
     * 获取刷怪蛋 ID
     *
     * @param id 生物 ID
     * @return 刷怪蛋 ID
     */
    public static String getEgg(String id) {
        return id + "_spawn_egg";
    }

    /**
     * 获取饱和度比值
     *
     * @param saturation 回复饱和度
     * @return 回复饱和度对于总饱和度的 0 ~ 1 比值
     */
    public static float getSaturationRatio(double saturation) {
        return (int) (saturation / 20);
    }

    /**
     * 注册特殊数据
     */
    public static void register() {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "sr_icon"), SR_ICON);
    }
}